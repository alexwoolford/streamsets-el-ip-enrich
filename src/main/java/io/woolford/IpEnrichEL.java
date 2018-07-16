package io.woolford;

import com.streamsets.pipeline.api.ElDef;
import com.streamsets.pipeline.api.ElFunction;
import com.streamsets.pipeline.api.ElParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;


@ElDef
public class IpEnrichEL {

    private static final Logger LOG = LoggerFactory.getLogger(IpEnrichEL.class);

    @ElFunction(
            prefix = "ip",
            name = "getCanonicalName",
            description = "Returns canonical name from an IP address."
    )
    public static String getCanonicalName (@ElParam("ipAddress") String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            return inetAddress.getCanonicalHostName();
        } catch (UnknownHostException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

}
