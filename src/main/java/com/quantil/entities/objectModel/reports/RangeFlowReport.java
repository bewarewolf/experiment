package com.quantil.entities.objectModel.reports;

import javax.xml.bind.annotation.*;

/**
 * Created by saddius on 8/11/2016.
 *
 * * Custom POJO class for parsing 'Service Type Time Range Traffic Volume Report' XML responses
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reports")
public class RangeFlowReport {

	public RangeFlowReport(){
    }

    @XmlElement(name = "flow-summary")
    private Double flowSummary;

    @XmlElement(name = "flow-in-range")
    private Double flowInRange;

    @XmlElement(name = "flow-out-range")
    private Double flowOutRange;

    public void setFlowSummary(Double flowSummary){
        this.flowSummary = flowSummary;
    }

    public Double getFlowSummary(){
        return flowSummary;
    }

    public void setFlowInRange(Double flowInRange){
        this.flowInRange = flowInRange;
    }

    public Double getFlowInRange(){
        return flowInRange;
    }

    public void setFlowOutRange(Double flowOutRange){
        this.flowOutRange = flowOutRange;
    }

    public Double getFlowOutRange(){
        return flowOutRange;
    }
}
