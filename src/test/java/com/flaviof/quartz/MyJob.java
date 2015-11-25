/**
 * Copyright (C) Bikeemotion
 * 2014
 *
 * The reproduction, transmission or use of this document or its contents is not
 * permitted without express written authorization. All rights, including rights
 * created by patent grant or registration of a utility model or design, are
 * reserved. Modifications made to this document are restricted to authorized
 * personnel only. Technical specifications and features are binding only when
 * specifically and expressly agreed upon in a written contract.
 */
package com.flaviof.quartz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public final class MyJob implements Job, Serializable {

  public static int count = 0;
  public static List<String> jobKeys = new ArrayList<>();

  @Override
  public void execute(final JobExecutionContext jobCtx)
    throws JobExecutionException {

    jobKeys.add(jobCtx.getJobDetail().getKey().getName());
    count++;
  }

}
