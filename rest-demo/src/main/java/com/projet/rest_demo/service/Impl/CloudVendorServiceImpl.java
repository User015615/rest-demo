package com.projet.rest_demo.service.impl;

import com.projet.rest_demo.exception.CloudVendorNotFoundException;

import com.projet.rest_demo.service.CloudVendorService;

import org.springframework.beans.factory.annotation.Autowired;
import com.projet.rest_demo.repository.CloudVendorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.projet.rest_demo.model.CloudVendor;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }
    
    @Override
    public String createCloudVendorDetails(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor created successfully";
    }

    @Override
    public String updateCloudVendorDetails(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor updated successfully";
    }

    @Override
    public String deleteCloudVendorDetails(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Cloud Vendor deleted successfully";
    }

    @Override
    public CloudVendor getCloudVendorDetails(String cloudVendorId) {
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Cloud Vendor does not exist");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
 
 