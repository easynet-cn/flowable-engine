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
package org.flowable.cmmn.engine.impl.persistence.entity;

import java.util.List;

import org.flowable.cmmn.api.delegate.DelegatePlanItemInstance;
import org.flowable.common.engine.impl.db.HasRevision;
import org.flowable.common.engine.impl.persistence.entity.Entity;
import org.flowable.variable.api.delegate.VariableScope;
import org.flowable.variable.service.impl.persistence.entity.VariableInstanceEntity;

/**
 * @author Joram Barrez
 */
public interface PlanItemInstanceEntity extends Entity, HasRevision, DelegatePlanItemInstance, EntityWithSentryPartInstances, PlanItemInstanceContainer {
    
    PlanItemInstanceEntity getStagePlanItemInstanceEntity();

    VariableScope getParentVariableScope();
    
    boolean isPlannedForActivationInMigration();
    void setPlannedForActivationInMigration(boolean plannedForActivationInMigration);

    boolean isStateChangeUnprocessed();
    void setStateChangeUnprocessed(boolean stateChangeUnprocessed);


    List<VariableInstanceEntity> getQueryVariables();
}
