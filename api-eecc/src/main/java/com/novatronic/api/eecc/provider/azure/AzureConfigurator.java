/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.provider.azure;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;

/**
 *
 * @author mrios
 */
public class AzureConfigurator {

    public static BlobClient getClient(String blobName) {
        BlobClient blobClient = new BlobClientBuilder()
                .connectionString("DefaultEndpointsProtocol=https;AccountName=testdummy1;AccountKey=EWV7a2CfP3mUnzkAPtGH/adAIigWRT70sTDm1l/kXEakTXsOzY7YO2WzZDaYb3IZ83Iz5ar7WMUPudPPb9T61g==;EndpointSuffix=core.windows.net")
                .containerName("container-0")
                .blobName(blobName).buildClient();
        return blobClient;
    }

}
