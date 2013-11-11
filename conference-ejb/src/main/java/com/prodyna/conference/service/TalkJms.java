package com.prodyna.conference.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.QueueConnectionFactory;
import javax.naming.InitialContext;

import org.slf4j.Logger;

import com.prodyna.conference.common.queue.QueueConnectionHandler;

@Stateless
public class TalkJms {
	/**
	 * Name of queue.
	 */
	private static final String QUEUE_TALK_CHANGE = "queue/talkupdated";

	/**
	 * Logger instance.
	 */
	@Inject
	private Logger log;

	/**
	 * Queue connection factory.
	 */
	@Inject
	private QueueConnectionFactory qcf;

	/**
	 * Initial context.
	 */
	@Inject
	private InitialContext iniCtx;

	/**
	 * Queue connection util.
	 */
	private QueueConnectionHandler queueConnectionHandler;

	/**
	 * Set up queue connection.
	 */
	@PostConstruct
	private void setupQueue() {
		queueConnectionHandler = new QueueConnectionHandler(qcf, iniCtx,
				QUEUE_TALK_CHANGE);
		queueConnectionHandler.connect();
	}

	@PreDestroy
	private void tearDownQueue() {
		queueConnectionHandler.disconnect();
	}

	public void sendMessage(String message) {
		try {
			queueConnectionHandler.sendMessage(message);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
