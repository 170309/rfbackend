package com.rfrongfei.onehammer.base.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by yihui on 2017/8/19.
 */
@Slf4j
public class PkgUtil {


    /**
     * 扫描包路径下所有的class文件
     *
     * @param pkg
     * @return
     */
    public static Set<Class<?>> getClzFromPkg(String pkg) {
        Set<Class<?>> classes = new LinkedHashSet<>();

        String pkgDirName = pkg.replace('.', '/');
        try {
            Enumeration<URL> urls = PkgUtil.class.getClassLoader().getResources(pkgDirName);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {// 如果是以文件的形式保存在服务器上
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");// 获取包的物理路径
                    findClassesByFile(pkg, filePath, classes);
                } else if ("jar".equals(protocol)) {// 如果是jar包文件
                    JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
                    findClassesByJar(pkg, jar, classes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public static void main(String[] args) {
        Set<Class<?>> clzFromPkg = getClzFromPkg("com.rfrongfei.onehammer");
        clzFromPkg.parallelStream()
                .filter(clazz -> clazz.getName().contains("entity"))
                .forEach(clazz->{
                    String clazzName = name(clazz.getName());
                    StringBuilder souts = new StringBuilder("type " + clazzName + "{");
                    Field[] declaredFields = clazz.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        boolean aStatic = Modifier.isStatic(declaredField.getModifiers());
                        if (!aStatic) {
                            String fieldName = declaredField.getName();
                            souts.append(fieldName).append(":");
                            if ("id".equalsIgnoreCase(fieldName)) {
                                souts.append("ID").append(",");
                            }else{
                                Class<?> type = declaredField.getType();
                                souts.append(name(type.getName())).append(",");
                            }
                        }
                    }
                    String toString = souts.toString();
                    String s = toString.substring(0, toString.length() - 1) + "}";
                    System.out.println(s);
                });
    }

    private static String name(String str){
        return str.substring(str.lastIndexOf(".")+1);
    }


    /**
     * 扫描包路径下的所有class文件
     *
     * @param pkgName 包名
     * @param pkgPath 包对应的绝对地址
     * @param classes 保存包路径下class的集合
     */
    private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) {
        File dir = new File(pkgPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }


        // 过滤获取目录，or class文件
        File[] dirfiles = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith("class"));


        if (dirfiles == null || dirfiles.length == 0) {
            return;
        }


        String className;
        Class clz;
        for (File f : dirfiles) {
            if (f.isDirectory()) {
                findClassesByFile(pkgName + "." + f.getName(),
                        pkgPath + "/" + f.getName(),
                        classes);
                continue;
            }


            // 获取类名，干掉 ".class" 后缀
            className = f.getName();
            className = className.substring(0, className.length() - 6);

            // 加载类
            clz = loadClass(pkgName + "." + className);
            if (clz != null) {
                classes.add(clz);
            }
        }
    }


    /**
     * 扫描包路径下的所有class文件
     *
     * @param pkgName 包名
     * @param jar     jar文件
     * @param classes 保存包路径下class的集合
     */
    private static void findClassesByJar(String pkgName, JarFile jar, Set<Class<?>> classes) {
        String pkgDir = pkgName.replace(".", "/");


        Enumeration<JarEntry> entry = jar.entries();

        JarEntry jarEntry;
        String name, className;
        Class<?> claze;
        while (entry.hasMoreElements()) {
            jarEntry = entry.nextElement();

            name = jarEntry.getName();
            if (name.charAt(0) == '/') {
                name = name.substring(1);
            }


            if (jarEntry.isDirectory() || !name.startsWith(pkgDir) || !name.endsWith(".class")) {
                // 非指定包路径， 非class文件
                continue;
            }


            // 去掉后面的".class", 将路径转为package格式
            className = name.substring(0, name.length() - 6);
            claze = loadClass(className.replace("/", "."));
            if (claze != null) {
                classes.add(claze);
            }
        }
    }


    private static Class<?> loadClass(String fullClzName) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
        } catch (ClassNotFoundException e) {
            log.error("load class error! clz: {}, e:{}", fullClzName, e);
        }
        return null;
    }
}
