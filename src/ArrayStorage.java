import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && uuid == storage[i].uuid){
                return storage[i];
            } else {
                System.out.println("\nNo such ID");
                break;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid){
                storage[i] = null;
                break;
            }
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null && i < storage.length - 1) {
                storage[i] = storage[i+1];
                storage[i+1] = null;
            } else if (i == storage.length - 1) {
                storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int Counter = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                Counter++;
            } else {
                break;
            }
        }

        storage = Arrays.copyOf(storage, Counter);
        return storage;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            } else {
                size++;
            }
        }
        return size;
    }
}