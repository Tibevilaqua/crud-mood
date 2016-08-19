package bevila.tiago.infrastructure.config.dbmigrations;

    import com.github.mongobee.changeset.ChangeLog;
    import com.github.mongobee.changeset.ChangeSet;
    import com.mongodb.BasicDBObjectBuilder;
    import com.mongodb.DB;
    import com.mongodb.DBCollection;

    import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    public static final String INITIAL_SET_UP_MIGRATION_PACKAGE_PATH = InitialSetupMigration.class.getPackage().getName();

    private Map<String, String>[] authoritiesUser = new Map[]{new HashMap<>()};

    private Map<String, String>[] authoritiesAdminAndUser = new Map[]{new HashMap<>(), new HashMap<>()};

    {
        authoritiesUser[0].put("_id", "ROLE_USER");
        authoritiesAdminAndUser[0].put("_id", "ROLE_USER");
        authoritiesAdminAndUser[1].put("_id", "ROLE_ADMIN");
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(DB db) {
        DBCollection usersCollection = db.getCollection("user");
        usersCollection.createIndex("login");
        usersCollection.createIndex("email");
        usersCollection.insert(BasicDBObjectBuilder.start()
                .add("_id", "user-0")
                .add("login", "system")
                .add("password", "$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG")
                .add("first_name", "")
                .add("last_name", "System")
                .add("email", "system@localhost")
                .get()
        );

    }
}
