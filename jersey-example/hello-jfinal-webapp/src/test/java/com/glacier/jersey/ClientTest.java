package com.glacier.jersey;

import com.glacier.domain.CaseHistory;
import com.glacier.domain.Code;
import com.glacier.domain.DocRequest;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * @author glacier
 * @version v1.0.0
 * @date <pre>2017-06-21 17:36</pre>
 */
public class ClientTest {

    @Test
    public void testGet() {
        List<Code> codes = RestClient.get("/code/1", new GenericType<List<Code>>() {
        }, null);

        System.out.println(codes);
    }

    @Test
    public void testPost() {
        DocRequest docRequest = new DocRequest("书号1", "姓名1", "1244x");
        List<CaseHistory> caseHistories = RestClient.post("/caseHistory",new GenericType<List<CaseHistory>>() {
        }, docRequest);
        System.out.println(caseHistories);
        System.out.println(caseHistories.get(0).getClass());
        System.out.println(caseHistories.get(0));
    }
}
