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
            }
        }
        return null;
    }

    void delete(String uuid) {
        //Set element to null
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid){
                storage[i] = null;
                break;
            }
        }
        //Move all elements to the left by 1 index
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
        
        Resume[] data = new Resume[Counter];
        for (int i = 0, j = 0; i < storage.length; i++, j++) {
            if (storage[i] != null) {
                data[i] = storage[j];
            } else {
                break;
            }
        }
        return data;
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