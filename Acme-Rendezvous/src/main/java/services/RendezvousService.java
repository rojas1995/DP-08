
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.RendezvousRepository;
import domain.Announcement;
import domain.Comment;
import domain.Rendezvous;
import domain.User;

@Service
@Transactional
public class RendezvousService {

	// Managed repository

	@Autowired
	private RendezvousRepository	rendezvousRepository;


	// Suporting services

	// Constructor

	public RendezvousService() {
		super();
	}

	// Simple CRUD methods

	public Rendezvous create() {
		final Rendezvous res = new Rendezvous();
		res.setComment(new ArrayList<Comment>());
		res.setAttendant(new ArrayList<User>());
		res.setSimilar(new ArrayList<Rendezvous>());
		res.setAnnouncement(new ArrayList<Announcement>());

		return res;
	}

	public Collection<Rendezvous> findAll() {
		Collection<Rendezvous> res;
		res = this.rendezvousRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Rendezvous findOne(final int rendezvousId) {
		Assert.isTrue(rendezvousId != 0);
		Rendezvous res;
		res = this.rendezvousRepository.findOne(rendezvousId);
		Assert.notNull(res);
		return res;
	}

	public Rendezvous save(final Rendezvous rendezvous) {
		Assert.notNull(rendezvous);
		Rendezvous res;
		res = this.rendezvousRepository.save(rendezvous);
		return res;

		//TODO A�adir restricci�n de future para date en controlador
	}

	public void delete(final Rendezvous rendezvous) {
		Assert.notNull(rendezvous);
		Assert.isTrue(rendezvous.getId() != 0);
		Assert.isTrue(this.rendezvousRepository.exists(rendezvous.getId()));
		this.rendezvousRepository.delete(rendezvous);
	}
	
	public Rendezvous findRendezvousByComment(int commentId){
		Rendezvous res;
		res = rendezvousRepository.findRendezvousByComment(commentId);
		
		return res;
	}
}
