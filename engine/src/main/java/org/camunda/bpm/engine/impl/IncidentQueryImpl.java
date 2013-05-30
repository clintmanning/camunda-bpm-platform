/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl;

import java.io.Serializable;
import java.util.List;

import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.impl.interceptor.CommandExecutor;
import org.camunda.bpm.engine.runtime.Incident;
import org.camunda.bpm.engine.runtime.IncidentQuery;

/**
 * @author roman.smirnov
 */
public class IncidentQueryImpl extends AbstractQuery<IncidentQuery, Incident> implements IncidentQuery, Serializable {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String incidentType;
  protected String executionId;
  protected String activityId;
  protected String processInstanceId;
  protected String processDefinitionId;
  protected String causeIncidentId;
  protected String rootCauseIncidentId;
  
  public IncidentQueryImpl() {
  }

  public IncidentQueryImpl(CommandContext commandContext) {
    super(commandContext);
  }

  public IncidentQueryImpl(CommandExecutor commandExecutor) {
    super(commandExecutor);
  }
  
  public IncidentQuery id(String id) {
    this.id = id;
    return this;
  }
  
  public IncidentQuery incidentType(String incidentType) {
    this.incidentType = incidentType;
    return this;
  }

  public IncidentQuery executionId(String executionId) {
    this.executionId = executionId;
    return this;
  }
  
  public IncidentQuery activityId(String activityId) {
    this.activityId = activityId;
    return this;
  }

  public IncidentQuery processInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
    return this;
  }
  
  public IncidentQuery processDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
    return this;
  }

  public IncidentQuery causeIncidentId(String causeIncidentId) {
    this.causeIncidentId = causeIncidentId;
    return this;
  }

  public IncidentQuery rootCauseIncidentId(String rootCauseIncidentId) {
    this.rootCauseIncidentId = rootCauseIncidentId;
    return this;
  }

  public long executeCount(CommandContext commandContext) {
    checkQueryOk();
    return commandContext
      .getIncidentManager()
      .findIncidentCountByQueryCriteria(this);
  }

  public List<Incident> executeList(CommandContext commandContext, Page page) {
    checkQueryOk();
    return commandContext
      .getIncidentManager()
      .findIncidentByQueryCriteria(this, page);
  }

}