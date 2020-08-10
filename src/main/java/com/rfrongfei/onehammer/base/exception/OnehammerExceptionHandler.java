package com.rfrongfei.onehammer.base.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OnehammerExceptionHandler implements GraphQLErrorHandler {

    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return errors != null && errors.size() >= 1;
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        System.out.println(list);
        return list;
    }
}
