package com.projet.rest_demo.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;

import com.projet.rest_demo.model.CloudVendor;

@DataJpaTest
public class CloudVendorRepositoryTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;
    
    @BeforeEach
    public void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxxx");
    }

    @AfterEach
    public void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> CloudVendorList = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(CloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(CloudVendorList.get(0).getVendorId())
                .isEqualTo(cloudVendor.getVendorAdress());
    }
}