conference
==========

Conference Management Tool


Modules:
-conference-ear: Builds EAR File for deployment
-conference-ejb: Contains models and Services
-conference-web: contains JSF Frontend and REST services.

Architecture:
conference-ejb:
packages:
com.prodyna.conference.common.jmx: Performance Report MBeanServer registration 
com.prodyna.conference.common.monitoring: Monitored Annotation, MonitoringInterceptor
com.prodyna.conference.model: Contains All JPA models
com.prodyna.conference.service: Contains all services and interfaces. GenericCrudService is the base for all crud services.
com.prodyna.conference.util: Contains producer for Recources (Currently only logger)


conference-web:
packages:
com.prodyna.conference.controller
Enthaelt alle JSF-Managedbeans. BasicController ist die Basis fuer Seiten, die Crudden (Edit*).
SecuritySession/SecurityController sind fuer Login/Logout.


com.prodyna.conference.converter
GenericIdConverter: Klasse fuer das convertieren von Url Parameter Id zu Entity.
 
com.prodyna.conference.rest
REST Services (TO BE implemented).

com.prodyna.conference.util
WebResources enthaelt Klasse fuer das erzeugen des FacesContext

Verzeichnisse
src/main/webapp/
All JSF Pages

src/main/webapp/WEB-INF/templates
Default template location

src/main/webapp/resources/custom
Custom Components developed for the conference Management for displaying/editing entities and links to entities. Also for editing technical parts like date, datetime.

src/main/webapp/resources/css
CSS Stylings
src/main/webapp/resources/gfx
Graphics


