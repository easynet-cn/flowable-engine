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

import java.util.Collection;
import java.util.List;

import org.flowable.cmmn.api.history.HistoricPlanItemInstance;
import org.flowable.cmmn.api.history.HistoricPlanItemInstanceQuery;
import org.flowable.cmmn.api.runtime.PlanItemInstance;
import org.flowable.cmmn.engine.impl.history.HistoricPlanItemInstanceQueryImpl;
import org.flowable.common.engine.impl.persistence.entity.EntityManager;

/**
 * @author Dennis Federico
 */
public interface HistoricPlanItemInstanceEntityManager extends EntityManager<HistoricPlanItemInstanceEntity> {

    HistoricPlanItemInstanceEntity create(PlanItemInstance planItemInstance);

    HistoricPlanItemInstanceQuery createHistoricPlanItemInstanceQuery();

    List<HistoricPlanItemInstance> findByCriteria(HistoricPlanItemInstanceQuery query);

    List<HistoricPlanItemInstance> findByCaseDefinitionId(String caseDefinitionId);

    long countByCriteria(HistoricPlanItemInstanceQuery query);
    
    void bulkDeleteHistoricPlanItemInstancesForCaseInstanceIds(Collection<String> caseInstanceIds);

    void deleteHistoricPlanItemInstancesForNonExistingCaseInstances();

    List<HistoricPlanItemInstance> findWithVariablesByCriteria(HistoricPlanItemInstanceQueryImpl historicPlanItemInstanceQuery);
}