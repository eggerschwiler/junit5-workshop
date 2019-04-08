package com.zuehlke.testing.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ATest {
	@Tag("slow")
	@Test
	void a() {
	}

	@Test
	void b() {
	}

	@Test
	void c() {
	}
}
