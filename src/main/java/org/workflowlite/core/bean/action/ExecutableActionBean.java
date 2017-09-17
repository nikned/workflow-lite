/********************************************************************
 * File Name:    ExecutableActionBean.java
 *
 * Date Created: Aug 16, 2017
 *
 * ------------------------------------------------------------------
 * 
 * Copyright @ 2017 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.workflowlite.core.bean.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.workflowlite.core.Action;
import org.workflowlite.core.ExecutionContext;
import org.workflowlite.core.bean.BeanInstantiator;
  
/**
 * TODO: Update with a detailed description of the interface/class.
 *
 */
public final class ExecutableActionBean extends ActionBean
{
  private ExecutableActionBean(final String activityBeanId, final BeanInstantiator beanInstantiator)
  {
    super(beanInstantiator);
    
    this.activityBeanId = activityBeanId;
  }
  
  @Override
  public Object execute(final ExecutionContext context, final Object source, final Object output)
  {
    LOGGER.debug("Creating instance of activity bean [{}]", this.activityBeanId);
    
    final Action<ExecutionContext, Object> activity = this.beanInstantiator.getAction(this.activityBeanId, context, source, output);

    LOGGER.info("Executing activity [{}]", activity.getName());
    
    final Object result = activity.execute(context);
    
    LOGGER.info("Action [{}] result: [{}]", activity.getName(), result); // TODO: Ajey - Log at debug level !!!
    
    return result;
  }
  
  // Private
  private final String activityBeanId;

  private static final Logger LOGGER = LoggerFactory.getLogger(ExecutableActionBean.class);
}
