package org.gardening.raisedbed.io;


import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
public class FileUtilsTest {
    @Test
    public void testReadFile() {
        assertEquals ("contents", FileUtils.read("testfile.txt"));
    }

    @Test
    public void testMissingFileThrowsRuntimeException() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            FileUtils.read("missingfile.txt");
        });

        assertEquals("java.io.FileNotFoundException: class path resource [missingfile.txt] cannot be opened because it does not exist", runtimeException.getMessage());
    }

}
