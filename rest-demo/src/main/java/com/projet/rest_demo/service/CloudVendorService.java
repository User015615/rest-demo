package com.projet.rest_demo.service;

import java.util.List;

import com.projet.rest_demo.model.CloudVendor;

public interface CloudVendorService {
    public String createCloudVendorDetails(CloudVendor cloudVendor);
    public String updateCloudVendorDetails(CloudVendor cloudVendor);
     public String deleteCloudVendorDetails(String cloudVendorId);
    public CloudVendor getCloudVendorDetails(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
}
