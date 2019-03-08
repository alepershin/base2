package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;
import static java.time.Month.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.contacts.put(PHONE, "+7(921) 855-0482");
        resume.contacts.put(SKYPE, "grigory.kislin");
        resume.contacts.put(MAIL, "gkislin@yandex.ru");
        resume.contacts.put(GITHUB, "https://github.com/gkislin");
        resume.contacts.put(STACKOVERFLOW, "548473");
        resume.contacts.put(HOMEPAGE, "http://gkislin.ru/");

        TextSection textSection = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.sections.put(OBJECTIVE, textSection);

        textSection = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.sections.put(PERSONAL, textSection);

        ListSection listSection = new ListSection(Arrays.asList(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        resume.sections.put(ACHIEVEMENT, listSection);

        listSection = new ListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)",
                "Python: Django",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов",
                "проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\""));
        resume.sections.put(QUALIFICATIONS, listSection);

        ArrayList<Organization> organizations = new ArrayList<>();

        Link homePage = new Link("Java Online Projects", "http://javaops.ru/");
        LocalDate startDate = LocalDate.of(2013, OCTOBER, 1);
        Calendar now = Calendar.getInstance();
        LocalDate endDate = LocalDate.of(now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH));
        Organization organization = new Organization(homePage, startDate, endDate, "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок");
        organizations.add(organization);

        organization.homePage = new Link("Wrike", "https://www.wrike.com/");
        organization.startDate = LocalDate.of(2014, OCTOBER, 1);
        organization.endDate = LocalDate.of(2016, JANUARY, 1);
        organization.title = "Старший разработчик (backend)";
        organization.description = "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO";
        organizations.add(organization);

        organization.homePage = new Link("RIT Center", "");
        organization.startDate = LocalDate.of(2012, APRIL, 1);
        organization.endDate = LocalDate.of(2014, OCTOBER, 1);
        organization.title = "Java архитектор";
        organization.description = "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python";
        organizations.add(organization);

        organization.homePage = new Link("Luxoft (Deutsche Bank)", "https://www.luxoft.com/");
        organization.startDate = LocalDate.of(2010, DECEMBER, 1);
        organization.endDate = LocalDate.of(2012, APRIL, 1);
        organization.title = "Ведущий программист";
        organization.description = "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5";
        organizations.add(organization);

        organization.homePage = new Link("Yota", "https://www.yota.ru/");
        organization.startDate = LocalDate.of(2008, JUNE, 1);
        organization.endDate = LocalDate.of(2010, DECEMBER, 1);
        organization.title = "Ведущий специалист";
        organization.description = "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)";
        organizations.add(organization);

        organization.homePage = new Link("Enkata", "https://www.pega.com/enkata/");
        organization.startDate = LocalDate.of(2007, MARCH, 1);
        organization.endDate = LocalDate.of(2008, JUNE, 1);
        organization.title = "Разработчик ПО";
        organization.description = "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)";
        organizations.add(organization);

        organization.homePage = new Link("Siemens AG", "https://new.siemens.com/ru/ru.html");
        organization.startDate = LocalDate.of(2005, JANUARY, 1);
        organization.endDate = LocalDate.of(2007, MARCH, 1);
        organization.title = "Разработчик ПО";
        organization.description = "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)";
        organizations.add(organization);

        organization.homePage = new Link("Alcatel", "http://www.alcatel.ru/");
        organization.startDate = LocalDate.of(1997, SEPTEMBER, 1);
        organization.endDate = LocalDate.of(2005, JANUARY, 1);
        organization.title = "Инженер по аппаратному и программному тестированию";
        organization.description = "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)";
        organizations.add(organization);
        OrganizationSection organizationSection = new OrganizationSection(organizations);
        resume.sections.put(EXPERIENCE, organizationSection);

        organizations.clear();

        organization.homePage = new Link("Coursera", "https://www.coursera.org/learn/progfun1");
        organization.startDate = LocalDate.of(2013, MARCH, 1);
        organization.endDate = LocalDate.of(2013, MAY, 1);
        organization.title = "\"Functional Programming Principles in Scala\" by Martin Odersky";
        organization.description = "";
        organizations.add(organization);

        organization.homePage = new Link("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy__analiz_is_kontseptualnoe_modelirovanie_na_uml_dlya_sistemnyh_analitikov_.html");
        organization.startDate = LocalDate.of(2011, MARCH, 1);
        organization.endDate = LocalDate.of(2011, APRIL, 1);
        organization.title = "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"";
        organization.description = "";
        organizations.add(organization);

        organization.homePage = new Link("Siemens AG", "https://new.siemens.com/ru/ru.html");
        organization.startDate = LocalDate.of(2005, JANUARY, 1);
        organization.endDate = LocalDate.of(2005, APRIL, 1);
        organization.title = "3 месяца обучения мобильным IN сетям (Берлин)";
        organization.description = "";
        organizations.add(organization);

        organization.homePage = new Link("Alcatel", "http://www.alcatel.ru/");
        organization.startDate = LocalDate.of(1997, SEPTEMBER, 1);
        organization.endDate = LocalDate.of(1998, MARCH, 1);
        organization.title = "6 месяцев обучения цифровым телефонным сетям (Москва)";
        organization.description = "";
        organizations.add(organization);

        organization.homePage = new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/ru/");
        organization.startDate = LocalDate.of(1993, SEPTEMBER, 1);
        organization.endDate = LocalDate.of(1996, JULY, 1);
        organization.title = "Аспирантура (программист С, С++)";
        organization.description = "";
        organizations.add(organization);

        organization.homePage = new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/ru/");
        organization.startDate = LocalDate.of(1987, SEPTEMBER, 1);
        organization.endDate = LocalDate.of(1993, JULY, 1);
        organization.title = "Инженер (программист Fortran, C)";
        organization.description = "";
        organizations.add(organization);

        organization.homePage = new Link("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/");
        organization.startDate = LocalDate.of(1984, SEPTEMBER, 1);
        organization.endDate = LocalDate.of(1987, JUNE, 1);
        organization.title = "Закончил с отличием";
        organization.description = "";
        organizations.add(organization);

        organizationSection = new OrganizationSection(organizations);
        resume.sections.put(EDUCATION, organizationSection);

        System.out.println(resume.fullName);
        System.out.println("Тел.: " + resume.getContact(PHONE));
        System.out.println("Skype: " + resume.getContact(SKYPE));
        System.out.println("Почта: " + resume.getContact(MAIL));
        System.out.println("Профиль LinkedIn " + resume.getContact(LINKEDIN));
        System.out.println("Профиль GitHub " + resume.getContact(GITHUB));
        System.out.println("Профиль Stackoverflow " + resume.getContact(STACKOVERFLOW));
        System.out.println("Домашняя страница: " + resume.getContact(HOMEPAGE));

        for (SectionType type : SectionType.values()){
            System.out.println(type.getTitle());
            System.out.println(resume.sections.get(type));
        }
    }
}
