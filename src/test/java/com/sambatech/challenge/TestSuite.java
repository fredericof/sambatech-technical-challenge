package com.sambatech.challenge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sambatech.challenge.resource.VideoResourceTest;
import com.sambatech.challenge.service.VideoServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ VideoResourceTest.class, VideoServiceTest.class })
public class TestSuite {

}