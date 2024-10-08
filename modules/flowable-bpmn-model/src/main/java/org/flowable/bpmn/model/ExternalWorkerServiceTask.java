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
package org.flowable.bpmn.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Filip Hrisafov
 */
public class ExternalWorkerServiceTask extends ServiceTask implements HasOutParameters, HasInParameters {

    protected String topic;
    protected boolean doNotIncludeVariables = false;
    protected List<IOParameter> inParameters = new ArrayList<>();
    protected List<IOParameter> outParameters = new ArrayList<>();

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isDoNotIncludeVariables() {
        return doNotIncludeVariables;
    }

    public void setDoNotIncludeVariables(boolean doNotIncludeVariables) {
        this.doNotIncludeVariables = doNotIncludeVariables;
    }

    @Override
    public List<IOParameter> getInParameters() {
        return inParameters;
    }

    @Override
    public void setInParameters(List<IOParameter> inParameters) {
        this.inParameters = inParameters;
    }

    @Override
    public void addInParameter(IOParameter inParameter) {
        this.inParameters.add(inParameter);
    }

    @Override
    public List<IOParameter> getOutParameters() {
        return outParameters;
    }

    @Override
    public void setOutParameters(List<IOParameter> outParameters) {
        this.outParameters = outParameters;
    }

    @Override
    public void addOutParameter(IOParameter outParameter) {
        this.outParameters.add(outParameter);
    }

    @Override
    public ExternalWorkerServiceTask clone() {
        ExternalWorkerServiceTask clone = new ExternalWorkerServiceTask();
        clone.setValues(this);
        return clone;
    }

    public void setValues(ExternalWorkerServiceTask otherElement) {
        super.setValues(otherElement);
        setTopic(otherElement.getTopic());
    }
}
