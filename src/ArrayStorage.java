import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        size = 0;
        storage = Arrays.copyOf(storage, size);
    }

    void save(Resume r) {
        size++;
        storage = Arrays.copyOf(storage, size);
        storage[size - 1] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid){
                size--;
                storage[i] = null;

                //Copy all elements but null into a new array
                Resume[] temp = new Resume[storage.length];
                for (int k = 0, j = 0; k < storage.length; k++) {
                    if (storage[k] != null) {
                        temp[j++] = storage[k];
                    }
                }

                storage = Arrays.copyOf(temp, size);
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return size;
    }
}