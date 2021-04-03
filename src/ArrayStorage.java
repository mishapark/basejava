import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    //Counter for newStorage length
    int counter = 0;
    //New Storage Arr
    Resume[] newStorage;

    void clear() {
        //Counting nulls
        int nullCounter = 0;
        for (Resume resume : newStorage) {
            if (resume == null) {
                nullCounter++;
            }
        }
        //Create new Arr
        Resume[] clearArr = new Resume[newStorage.length-nullCounter];
        //Add non-null values to new Arr
        for (int i = 0, j = 0; i < newStorage.length; i++) {
            if (newStorage[i] != null) {
                clearArr[j] = newStorage[i];
                j++;
            }
        }
        //Copying new Arr to old Arr
        newStorage = clearArr;
    }

    void save(Resume r) {
        //Increase length by 1
        counter++;
        newStorage = Arrays.copyOf(storage, counter);    //Resume[] newStorage = {null}

        //Insert new resume to Arr
        for (int i = 0; i < newStorage.length; i++) {    //newStorage.length = 1
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }

        //Copy updated Arr
        newStorage = Arrays.copyOf(storage, counter);     //Resume[] newStorage = {r}
    }

    Resume get(String uuid) {
        for (Resume resume : newStorage) {
            if (uuid == resume.uuid) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < newStorage.length; i++) {
            if (newStorage[i].uuid == uuid) {
                newStorage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return newStorage;
    }

    int size() {
        return newStorage.length;
    }
}
