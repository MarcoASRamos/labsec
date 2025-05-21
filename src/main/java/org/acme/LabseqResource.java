package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Path("/labseq")
public class LabseqResource {

    private final Map<Long, BigInteger> cache = new HashMap<>();
    private Long discovered_n = (long) 3;

    public LabseqResource() {
        cache.put(0L, BigInteger.ZERO);
        cache.put(1L, BigInteger.ONE);
        cache.put(2L, BigInteger.ZERO);
        cache.put(3L, BigInteger.ONE);
    }


    @GET
    @Path("{n}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Calculate labseq value", description = "Returns the labseq sequence value corresponding to the integer index `n`")
    @APIResponse(responseCode = "200", description = "Successful response containing the calculated labseq value.")
    @APIResponse(responseCode = "400", description = "Invalid input: `n` must be a non-negative integer.")
    public Response getLabseq(@Parameter(description = "Index (non-negative integer) to calculate the labseq value.")@PathParam("n") Long n) {
        if (n < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("n must be a non-negative integer.")
                    .build();
        }
        if (n > discovered_n) {
            labseq(n);
            discovered_n = n;
        } 
        return Response.ok(String.valueOf(cache.get(n))).build();
    }

    private void labseq(Long n) {
        for (long i = discovered_n + 1; i <= n; i++) {
            BigInteger value = cache.get(i - 4).add(cache.get(i - 3));
            cache.put(i, value);
        }
    }
}

