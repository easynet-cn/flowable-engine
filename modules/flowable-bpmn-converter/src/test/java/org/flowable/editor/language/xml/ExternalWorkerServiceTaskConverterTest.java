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
package org.flowable.editor.language.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.ExternalWorkerServiceTask;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.IOParameter;
import org.flowable.editor.language.xml.util.BpmnXmlConverterTest;

class ExternalWorkerServiceTaskConverterTest {

    @BpmnXmlConverterTest("externalWorkerServiceTask.bpmn")
    void validateModel(BpmnModel model) {
        FlowElement flowElement = model.getMainProcess().getFlowElement("externalWorkerServiceTask");
        assertThat(flowElement).isInstanceOf(ExternalWorkerServiceTask.class);
        assertThat(flowElement.getId()).isEqualTo("externalWorkerServiceTask");
        assertThat(flowElement.getName()).isEqualTo("External worker task");
        ExternalWorkerServiceTask externalWorkerServiceTask = (ExternalWorkerServiceTask) flowElement;

        assertThat(externalWorkerServiceTask.getTopic()).isEqualTo("topic");
        assertThat(externalWorkerServiceTask.getSkipExpression()).isEqualTo("skipExpression");
        assertThat(externalWorkerServiceTask.isExclusive()).isTrue();

        assertThat(externalWorkerServiceTask.getInParameters()).hasSize(1);
        IOParameter inParameter = externalWorkerServiceTask.getInParameters().get(0);
        assertThat(inParameter.getSource()).isEqualTo("description");
        assertThat(inParameter.getTarget()).isEqualTo("theDescription");
        assertThat(externalWorkerServiceTask.getOutParameters()).hasSize(1);
        IOParameter outParameter = externalWorkerServiceTask.getOutParameters().get(0);
        assertThat(outParameter.getSource()).isEqualTo("theResult");
        assertThat(outParameter.getTarget()).isEqualTo("result");

    }
}
