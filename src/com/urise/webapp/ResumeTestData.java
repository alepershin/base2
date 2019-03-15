package com.urise.webapp;

import com.urise.webapp.model.*;
import com.urise.webapp.storage.ArrayStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;
import static java.time.Month.*;

public class ResumeTestData {
    static final ArrayStorage storage = new ArrayStorage();

    public static void main(String[] args) {
        Resume RESUME_1 = new Resume("uuid1", "Григорий Кислин");
        RESUME_1.contacts.put(PHONE, "+7(921) 855-0482");
        RESUME_1.contacts.put(SKYPE, "grigory.kislin");
        RESUME_1.contacts.put(MAIL, "gkislin@yandex.ru");
        RESUME_1.contacts.put(GITHUB, "https://github.com/gkislin");
        RESUME_1.contacts.put(STACKOVERFLOW, "548473");
        RESUME_1.contacts.put(HOMEPAGE, "http://gkislin.ru/");

        TextSection textSection = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        RESUME_1.sections.put(OBJECTIVE, textSection);

        textSection = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        RESUME_1.sections.put(PERSONAL, textSection);

        ListSection listSection = new ListSection(Arrays.asList(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        RESUME_1.sections.put(ACHIEVEMENT, listSection);

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
        RESUME_1.sections.put(QUALIFICATIONS, listSection);

        ArrayList<Organization> itemExperience = new ArrayList<>();

        Link homePage = new Link("Java Online Projects", "http://javaops.ru/");
        LocalDate startDate = LocalDate.of(2013, OCTOBER, 1);
        Calendar now = Calendar.getInstance();
        LocalDate endDate = LocalDate.of(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        PeriodOrganization periodOrganization = new PeriodOrganization(startDate, endDate, "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок");
        Organization organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("Wrike", "https://www.wrike.com/");
        startDate = LocalDate.of(2014, OCTOBER, 1);
        endDate = LocalDate.of(2016, JANUARY, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("RIT Center", "");
        startDate = LocalDate.of(2012, APRIL, 1);
        endDate = LocalDate.of(2014, OCTOBER, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("Luxoft (Deutsche Bank)", "https://www.luxoft.com/");
        startDate = LocalDate.of(2010, DECEMBER, 1);
        endDate = LocalDate.of(2012, APRIL, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("Yota", "https://www.yota.ru/");
        startDate = LocalDate.of(2008, JUNE, 1);
        endDate = LocalDate.of(2010, DECEMBER, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("Enkata", "https://www.pega.com/enkata/");
        startDate = LocalDate.of(2007, MARCH, 1);
        endDate = LocalDate.of(2008, JUNE, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("Siemens AG", "https://new.siemens.com/ru/ru.html");
        startDate = LocalDate.of(2005, JANUARY, 1);
        endDate = LocalDate.of(2007, MARCH, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        homePage = new Link("Alcatel", "http://www.alcatel.ru/");
        startDate = LocalDate.of(1997, SEPTEMBER, 1);
        endDate = LocalDate.of(2005, JANUARY, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemExperience.add(organization);

        OrganizationSection organizationSection = new OrganizationSection(itemExperience);
        RESUME_1.sections.put(EXPERIENCE, organizationSection);

        ArrayList<Organization> itemEducation = new ArrayList<>();

        homePage = new Link("Coursera", "https://www.coursera.org/learn/progfun1");
        startDate = LocalDate.of(2013, MARCH, 1);
        endDate = LocalDate.of(2013, MAY, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "\"Functional Programming Principles in Scala\" by Martin Odersky", "");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemEducation.add(organization);

        homePage = new Link("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy__analiz_is_kontseptualnoe_modelirovanie_na_uml_dlya_sistemnyh_analitikov_.html");
        startDate = LocalDate.of(2011, MARCH, 1);
        endDate = LocalDate.of(2011, APRIL, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemEducation.add(organization);

        homePage = new Link("Siemens AG", "https://new.siemens.com/ru/ru.html");
        startDate = LocalDate.of(2005, JANUARY, 1);
        endDate = LocalDate.of(2005, APRIL, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "3 месяца обучения мобильным IN сетям (Берлин)", "");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemEducation.add(organization);

        homePage = new Link("Alcatel", "http://www.alcatel.ru/");
        startDate = LocalDate.of(1997, SEPTEMBER, 1);
        endDate = LocalDate.of(1998, MARCH, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "6 месяцев обучения цифровым телефонным сетям (Москва)", "");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemEducation.add(organization);

        homePage = new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/ru/");
        startDate = LocalDate.of(1993, SEPTEMBER, 1);
        endDate = LocalDate.of(1996, JULY, 1);
        PeriodOrganization period1 = new PeriodOrganization(startDate, endDate, "Аспирантура (программист С, С++)", "");
        startDate = LocalDate.of(1987, SEPTEMBER, 1);
        endDate = LocalDate.of(1993, JULY, 1);
        PeriodOrganization period2 = new PeriodOrganization(startDate, endDate, "Инженер (программист Fortran, C)", "");
        organization = new Organization(homePage, Arrays.asList(period1, period2));
        itemEducation.add(organization);

        homePage = new Link("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/");
        startDate = LocalDate.of(1984, SEPTEMBER, 1);
        endDate = LocalDate.of(1987, JUNE, 1);
        periodOrganization = new PeriodOrganization(startDate, endDate, "Закончил с отличием", "");
        organization = new Organization(homePage, Arrays.asList(periodOrganization));
        itemEducation.add(organization);

        organizationSection = new OrganizationSection(itemEducation);
        RESUME_1.sections.put(EDUCATION, organizationSection);

        storage.clear();
        storage.save(RESUME_1);

        Resume RESUME_2 = new Resume("uuid2", "Першин Алексей");
        RESUME_2.contacts.put(PHONE, "+79512041892");
        RESUME_2.contacts.put(MAIL, "alepershin@mail.ru");

        Resume RESUME_3 = new Resume("uuid3", "fullName3");
        Resume RESUME_4 = new Resume("uuid4", "fullName4");

        storage.save(RESUME_2);
        storage.save(RESUME_3);
        System.out.println(storage.size());
        storage.save(RESUME_4);
        System.out.println(storage.size());

    }
}
