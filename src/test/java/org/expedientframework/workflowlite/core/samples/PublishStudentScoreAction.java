/********************************************************************
 * File Name:    PublishStudentScoreAction.java
 *
 * Date Created: Sep 17, 2017
 *
 * ------------------------------------------------------------------
 * 
 * Copyright @ 2017 ajeydudhe@gmail.com
 *
 *******************************************************************/

package org.expedientframework.workflowlite.core.samples;

import org.expedientframework.workflowlite.core.AbstractAction;
import org.expedientframework.workflowlite.core.ExecutionContext;
  
public class PublishStudentScoreAction extends AbstractAction<ExecutionContext, String>
{
  public PublishStudentScoreAction(final String studentName, final int score)
  {
    this.studentName = studentName;
    this.score = score;
  }
  
  @Override
  public String execute(final ExecutionContext context)
  {
    return String.format("Student '%s' scored %d marks.", this.studentName, this.score);
  }
  
  // Private
  private final String studentName;
  private final int score;
}

