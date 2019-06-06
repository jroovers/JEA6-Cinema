package cinema.cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
