package com.glacier.jersey;

import com.glacier.domain.CaseHistory;
import com.glacier.domain.DocRequest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author glacier
 * @version v1.0.0
 * @Date 2017-08-21  10:43:42
 */
@Singleton
@Path("case")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf8")
public class CaseResource {

    @GET
    @Path("/code/{type}")
    @Produces(MediaType.TEXT_HTML)
    public String code(@PathParam("type") int type) {
        return "code";
    }


    @GET
    @Path("/name")
    public List<CaseHistory> hello() {
        List<CaseHistory> caseHistories = RestClient.post("/caseHistory", new GenericType<List<CaseHistory>>() {
        }, new DocRequest());
        return caseHistories;
    }
}
