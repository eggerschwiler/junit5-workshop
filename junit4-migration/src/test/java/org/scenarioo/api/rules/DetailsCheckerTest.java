package org.scenarioo.api.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.scenarioo.api.exception.IllegalCharacterException;
import org.scenarioo.model.docu.entities.generic.Details;
import org.scenarioo.model.docu.entities.generic.ObjectDescription;

public class DetailsCheckerTest {
	
	private static final String ILLEGAL_IDENTIFIER = "/illegal";
	private static final String LEGAL_IDENTIFIER = "legal";

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void ifDetailsIsNull_theCheckPasses() {
		DetailsChecker.checkIdentifiers(null);
	}
	
	@Test
	public void ifAllIdentifiersAreValid_theCheckPasses() {
		DetailsChecker.checkIdentifiers(getDetailsWithValidIdentifiers());
	}
	
	@Test
	public void ifThereIsAnInvalidObjectType_anExceptionIsThrown() {
		thrown.expect(IllegalCharacterException.class);
		thrown.expectMessage("Identifier /illegal contains illegal characters.");
		DetailsChecker.checkIdentifiers(getDetailsWithInvalidObjectType());
	}
	
	@Test
	public void ifThereIsAnInvalidObjectName_anExceptionIsThrown() {
		thrown.expect(IllegalCharacterException.class);
		thrown.expectMessage("Identifier /illegal contains illegal characters.");
		DetailsChecker.checkIdentifiers(getDetailsWithInvalidObjectName());
	}
	
	private Details getDetailsWithInvalidObjectType() {
		Details details = getDetailsWithValidIdentifiers();
		details.addDetail("invalid", getObjectDescriptionWithInvalidObjectType());
		return details;
	}
	
	private Details getDetailsWithInvalidObjectName() {
		Details details = getDetailsWithValidIdentifiers();
		details.addDetail("invalid", getObjectDescriptionWithInvalidObjectName());
		return details;
	}
	
	private ObjectDescription getObjectDescriptionWithInvalidObjectType() {
		return new ObjectDescription(ILLEGAL_IDENTIFIER, LEGAL_IDENTIFIER);
	}
	
	private ObjectDescription getObjectDescriptionWithInvalidObjectName() {
		ObjectDescription objectDescription = new ObjectDescription(LEGAL_IDENTIFIER, LEGAL_IDENTIFIER);
		objectDescription.addDetail("illegal", createObjectDescriptionWithInvalidObjectName());
		return objectDescription;
	}
	
	private ObjectDescription createObjectDescriptionWithInvalidObjectName() {
		return new ObjectDescription(LEGAL_IDENTIFIER, ILLEGAL_IDENTIFIER);
	}
	
	private Details getDetailsWithValidIdentifiers() {
		Details details = new Details();
		details.addDetail("test", createObjectDescriptionWithValidIdentifiers());
		return details;
	}
	
	private ObjectDescription createObjectDescriptionWithValidIdentifiers() {
		return new ObjectDescription(LEGAL_IDENTIFIER, LEGAL_IDENTIFIER);
	}
	
}
