package io.woolford;


import org.junit.Assert;
import org.junit.Test;


public class TestIpEnrichEL {

    @Test
    public void testGetCanonicalName() {

        String ip = "73.229.55.206";
        String canonicalName = IpEnrichEL.getCanonicalName(ip);
        Assert.assertEquals("c-73-229-55-206.hsd1.co.comcast.net", canonicalName);
    }

}
