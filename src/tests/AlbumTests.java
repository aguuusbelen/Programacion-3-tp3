package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelos.Album;

public class AlbumTests {
	
	@Test
	void test() {
		Album album = new Album(638);
		
		assertTrue(album.getFiguritas() != null);
	}

}
