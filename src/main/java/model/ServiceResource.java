package model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class ServiceResource
 */
@Stateless
@LocalBean
@Path("Services")
public class ServiceResource {
	@PersistenceContext(unitName = "JPAProject")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ServiceResource() {
		// TODO Auto-generated constructor stub
	}

@Path("learners")
@GET
@Produces(value= {MediaType.APPLICATION_JSON})
	public Response getAllLearners() {
		List<Learner> learners = new ArrayList<Learner>();

		TypedQuery<Learner> query = em.createNamedQuery("Learner.findAll", Learner.class);
		learners = query.getResultList();

		if (learners.size() != 0)
			return Response.status(200).entity(learners).build();
		else
			return Response.status(200).entity("There is no saved learner in the DB").build();
	};

}
