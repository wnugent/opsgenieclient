package com.ifountain.opsgenie.client.model.schedule;

import com.ifountain.opsgenie.client.OpsGenieClientConstants;
import com.ifountain.opsgenie.client.OpsGenieClientValidationException;
import com.ifountain.opsgenie.client.model.BaseRequest;

import java.util.Map;

/**
 * Container for the parameters to make an delete schedule override api call.
 *
 * @author Sezgin Kucukkaraaslan
 * @version 12/3/2014 9:02 AM
 * @see com.ifountain.opsgenie.client.IScheduleOpsGenieClient#deleteScheduleOverride(DeleteScheduleOverrideRequest)
 */
public class DeleteScheduleOverrideRequest extends BaseRequest<DeleteScheduleOverrideResponse> {
    private String alias;
    private String schedule;

    /**
     * Rest api uri of delete schedule override operation.
     */
    @Override
    public String getEndPoint() {
        return "/v1/json/schedule/override";
    }

    /**
     * A user defined identifier for the override.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets a user defined identifier for the override.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Id or the name of the schedule that the override belongs to.
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Sets the id or the name of the schedule that the override belongs to.
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    /**
     * @see com.ifountain.opsgenie.client.model.BaseRequest#serialize()
     */
    public Map serialize() throws OpsGenieClientValidationException {
        Map json = super.serialize();
        json.put(OpsGenieClientConstants.API.SCHEDULE, getSchedule());
        json.put(OpsGenieClientConstants.API.ALIAS, getAlias());
        return json;
    }

    @Override
    /**
     * @see com.ifountain.opsgenie.client.model.BaseRequest#createResponse()
     */
    public DeleteScheduleOverrideResponse createResponse() {
        return new DeleteScheduleOverrideResponse();
    }
}
