package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_gouravsproject_realmClassRealmProxy extends com.example.gouravsproject.realmClass
    implements RealmObjectProxy, com_example_gouravsproject_realmClassRealmProxyInterface {

    static final class realmClassColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long rollnoIndex;
        long subjectIndex;
        long marksIndex;
        long nameIndex;
        long sectionIndex;

        realmClassColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("realmClass");
            this.rollnoIndex = addColumnDetails("rollno", "rollno", objectSchemaInfo);
            this.subjectIndex = addColumnDetails("subject", "subject", objectSchemaInfo);
            this.marksIndex = addColumnDetails("marks", "marks", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.sectionIndex = addColumnDetails("section", "section", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        realmClassColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new realmClassColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final realmClassColumnInfo src = (realmClassColumnInfo) rawSrc;
            final realmClassColumnInfo dst = (realmClassColumnInfo) rawDst;
            dst.rollnoIndex = src.rollnoIndex;
            dst.subjectIndex = src.subjectIndex;
            dst.marksIndex = src.marksIndex;
            dst.nameIndex = src.nameIndex;
            dst.sectionIndex = src.sectionIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private realmClassColumnInfo columnInfo;
    private ProxyState<com.example.gouravsproject.realmClass> proxyState;

    com_example_gouravsproject_realmClassRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (realmClassColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.gouravsproject.realmClass>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$rollno() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rollnoIndex);
    }

    @Override
    public void realmSet$rollno(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rollnoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rollnoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$subject() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.subjectIndex);
    }

    @Override
    public void realmSet$subject(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.subjectIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.subjectIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.subjectIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.subjectIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$marks() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.marksIndex);
    }

    @Override
    public void realmSet$marks(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.marksIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.marksIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$section() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sectionIndex);
    }

    @Override
    public void realmSet$section(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sectionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sectionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sectionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sectionIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("realmClass", 5, 0);
        builder.addPersistedProperty("rollno", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("subject", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("marks", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("section", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static realmClassColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new realmClassColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "realmClass";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "realmClass";
    }

    @SuppressWarnings("cast")
    public static com.example.gouravsproject.realmClass createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.gouravsproject.realmClass obj = realm.createObjectInternal(com.example.gouravsproject.realmClass.class, true, excludeFields);

        final com_example_gouravsproject_realmClassRealmProxyInterface objProxy = (com_example_gouravsproject_realmClassRealmProxyInterface) obj;
        if (json.has("rollno")) {
            if (json.isNull("rollno")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rollno' to null.");
            } else {
                objProxy.realmSet$rollno((int) json.getInt("rollno"));
            }
        }
        if (json.has("subject")) {
            if (json.isNull("subject")) {
                objProxy.realmSet$subject(null);
            } else {
                objProxy.realmSet$subject((String) json.getString("subject"));
            }
        }
        if (json.has("marks")) {
            if (json.isNull("marks")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'marks' to null.");
            } else {
                objProxy.realmSet$marks((int) json.getInt("marks"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("section")) {
            if (json.isNull("section")) {
                objProxy.realmSet$section(null);
            } else {
                objProxy.realmSet$section((String) json.getString("section"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.gouravsproject.realmClass createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.gouravsproject.realmClass obj = new com.example.gouravsproject.realmClass();
        final com_example_gouravsproject_realmClassRealmProxyInterface objProxy = (com_example_gouravsproject_realmClassRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("rollno")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rollno((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rollno' to null.");
                }
            } else if (name.equals("subject")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$subject((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$subject(null);
                }
            } else if (name.equals("marks")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$marks((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'marks' to null.");
                }
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("section")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$section((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$section(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_example_gouravsproject_realmClassRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.gouravsproject.realmClass.class), false, Collections.<String>emptyList());
        io.realm.com_example_gouravsproject_realmClassRealmProxy obj = new io.realm.com_example_gouravsproject_realmClassRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.gouravsproject.realmClass copyOrUpdate(Realm realm, realmClassColumnInfo columnInfo, com.example.gouravsproject.realmClass object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.gouravsproject.realmClass) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.gouravsproject.realmClass copy(Realm realm, realmClassColumnInfo columnInfo, com.example.gouravsproject.realmClass newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.gouravsproject.realmClass) cachedRealmObject;
        }

        com_example_gouravsproject_realmClassRealmProxyInterface realmObjectSource = (com_example_gouravsproject_realmClassRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.gouravsproject.realmClass.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.rollnoIndex, realmObjectSource.realmGet$rollno());
        builder.addString(columnInfo.subjectIndex, realmObjectSource.realmGet$subject());
        builder.addInteger(columnInfo.marksIndex, realmObjectSource.realmGet$marks());
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.sectionIndex, realmObjectSource.realmGet$section());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_gouravsproject_realmClassRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.gouravsproject.realmClass object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.gouravsproject.realmClass.class);
        long tableNativePtr = table.getNativePtr();
        realmClassColumnInfo columnInfo = (realmClassColumnInfo) realm.getSchema().getColumnInfo(com.example.gouravsproject.realmClass.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rollnoIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$rollno(), false);
        String realmGet$subject = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$subject();
        if (realmGet$subject != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.marksIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$marks(), false);
        String realmGet$name = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$section = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$section();
        if (realmGet$section != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sectionIndex, rowIndex, realmGet$section, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.gouravsproject.realmClass.class);
        long tableNativePtr = table.getNativePtr();
        realmClassColumnInfo columnInfo = (realmClassColumnInfo) realm.getSchema().getColumnInfo(com.example.gouravsproject.realmClass.class);
        com.example.gouravsproject.realmClass object = null;
        while (objects.hasNext()) {
            object = (com.example.gouravsproject.realmClass) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rollnoIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$rollno(), false);
            String realmGet$subject = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$subject();
            if (realmGet$subject != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.marksIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$marks(), false);
            String realmGet$name = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$section = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$section();
            if (realmGet$section != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sectionIndex, rowIndex, realmGet$section, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.gouravsproject.realmClass object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.gouravsproject.realmClass.class);
        long tableNativePtr = table.getNativePtr();
        realmClassColumnInfo columnInfo = (realmClassColumnInfo) realm.getSchema().getColumnInfo(com.example.gouravsproject.realmClass.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.rollnoIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$rollno(), false);
        String realmGet$subject = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$subject();
        if (realmGet$subject != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.subjectIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.marksIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$marks(), false);
        String realmGet$name = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$section = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$section();
        if (realmGet$section != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sectionIndex, rowIndex, realmGet$section, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sectionIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.gouravsproject.realmClass.class);
        long tableNativePtr = table.getNativePtr();
        realmClassColumnInfo columnInfo = (realmClassColumnInfo) realm.getSchema().getColumnInfo(com.example.gouravsproject.realmClass.class);
        com.example.gouravsproject.realmClass object = null;
        while (objects.hasNext()) {
            object = (com.example.gouravsproject.realmClass) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.rollnoIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$rollno(), false);
            String realmGet$subject = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$subject();
            if (realmGet$subject != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.subjectIndex, rowIndex, realmGet$subject, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.subjectIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.marksIndex, rowIndex, ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$marks(), false);
            String realmGet$name = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$section = ((com_example_gouravsproject_realmClassRealmProxyInterface) object).realmGet$section();
            if (realmGet$section != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sectionIndex, rowIndex, realmGet$section, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sectionIndex, rowIndex, false);
            }
        }
    }

    public static com.example.gouravsproject.realmClass createDetachedCopy(com.example.gouravsproject.realmClass realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.gouravsproject.realmClass unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.gouravsproject.realmClass();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.gouravsproject.realmClass) cachedObject.object;
            }
            unmanagedObject = (com.example.gouravsproject.realmClass) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_gouravsproject_realmClassRealmProxyInterface unmanagedCopy = (com_example_gouravsproject_realmClassRealmProxyInterface) unmanagedObject;
        com_example_gouravsproject_realmClassRealmProxyInterface realmSource = (com_example_gouravsproject_realmClassRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$rollno(realmSource.realmGet$rollno());
        unmanagedCopy.realmSet$subject(realmSource.realmGet$subject());
        unmanagedCopy.realmSet$marks(realmSource.realmGet$marks());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$section(realmSource.realmGet$section());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("realmClass = proxy[");
        stringBuilder.append("{rollno:");
        stringBuilder.append(realmGet$rollno());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subject:");
        stringBuilder.append(realmGet$subject() != null ? realmGet$subject() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{marks:");
        stringBuilder.append(realmGet$marks());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{section:");
        stringBuilder.append(realmGet$section() != null ? realmGet$section() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_gouravsproject_realmClassRealmProxy arealmClass = (com_example_gouravsproject_realmClassRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = arealmClass.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = arealmClass.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != arealmClass.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
