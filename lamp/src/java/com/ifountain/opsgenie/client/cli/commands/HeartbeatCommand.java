package com.ifountain.opsgenie.client.cli.commands;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.ifountain.opsgenie.client.IOpsGenieClient;
import com.ifountain.opsgenie.client.model.customer.HeartbeatRequest;
import com.ifountain.opsgenie.client.model.customer.HeartbeatResponse;

/**
 * Created by Sezgin Kucukkaraaslan
 * Date: 6/4/12
 * Time: 9:46 AM
 */
@Parameters(commandDescription = "Sends heartbeat to Opsgenie.")
public class HeartbeatCommand extends BaseCommand{
    @ParametersDelegate
    private CommonCommandOptions commonOptions = new CommonCommandOptions();

    public HeartbeatCommand(JCommander commander) {
        super(commander);
    }

    @Override
    public String getName() {
        return "heartbeat";
    }

    @Override
    public void doExecute(IOpsGenieClient opsGenieClient) throws Exception {
        HeartbeatRequest request = new HeartbeatRequest();
        request.setApiKey(commonOptions.getApiKey());
        HeartbeatResponse response = opsGenieClient.heartbeat(request);
        System.out.println("heartbeat=" + response.getHeartbeat());
    }

    @Override
    protected CommonCommandOptions getCommonCommandOptions() {
        return commonOptions;
    }
}
