package org.jboss.windup.engine.visitor.reporter;

import javax.inject.Inject;

import org.jboss.windup.engine.visitor.base.AbstractGraphVisitor;
import org.jboss.windup.graph.dao.JarArchiveDaoBean;
import org.jboss.windup.graph.model.resource.JarArchive;
import org.jboss.windup.graph.model.resource.JavaClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For each JAR, list the classes it provides.
 * 
 * @author bradsdavis@gmail.com
 *
 */
public class ArchiveProvidesReporter extends AbstractGraphVisitor {

	private static final Logger LOG = LoggerFactory.getLogger(ArchiveProvidesReporter.class);
	
	@Inject
	private JarArchiveDaoBean jarDao;
	
	@Override
	public void run() {
		for(JarArchive archive : jarDao.getAll()) {
			LOG.info("Archive: "+archive.getArchiveName());
			
			for(JavaClass clz : archive.getJavaClasses()) {
				LOG.info(" - Provides: "+clz.getQualifiedName());
			}
		}
	}
}