package entitiescleaner.cleaner;

import java.util.ArrayList;
import java.util.List;

/**
 * エンティティ削除のコードはgithubより引用
 * @author https://github.com/organization/EntitiesCleaner-Nukkit/
 *
 */

public class CleanerManager {

    private static final List<Cleaner> cleaners = new ArrayList<>();

    public static void addCleaner(Cleaner cleaner) {
        cleaners.add(cleaner);
    }

    public static void removeCleaner(Cleaner cleaner) {
        cleaners.remove(cleaner);
    }

    public static void cleanEntities() {
        cleaners.forEach(Cleaner::clean);
    }
}