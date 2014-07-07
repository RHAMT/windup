/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.windup.config.operation.iteration;

import org.jboss.windup.config.operation.Iteration;
import org.jboss.windup.config.runner.VarStack;
import org.jboss.windup.graph.model.WindupVertexFrame;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class NamedIterationPayloadManager implements IterationPayloadManager
{
    private final String var;

    public NamedIterationPayloadManager(String var)
    {
        this.var = var;
    }

    @Override
    public void setCurrentPayload(VarStack varStack, WindupVertexFrame element)
    {
        Iteration.setCurrentPayload(varStack, var, element);
    }

    @Override
    public void removeCurrentPayload(VarStack varStack)
    {
        Iteration.removeCurrentPayload(varStack, null, var);
    }

}
