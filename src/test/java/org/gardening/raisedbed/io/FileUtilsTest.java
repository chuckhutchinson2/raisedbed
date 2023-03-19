package org.gardening.raisedbed.io;


import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
public class FileUtilsTest {
    @Test
    public void testReadFile() {
        assertEquals ("contents", FileUtils.read("testfile.txt"));
    }
}
