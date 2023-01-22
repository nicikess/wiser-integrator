package ch.unisg.ics.interactions.wiser.queries.ecoSpold;

import ch.unisg.ics.interactions.wiser.data.ecoSpold.FileAttributes;
import ch.unisg.ics.interactions.wiser.tools.VocabularyEcoSpold;

public class FileAttributesQueryBuilder {

    private FileAttributes fileAttributes;
    private String identifier;

    public FileAttributesQueryBuilder(FileAttributes fileAttributes, String activityIdEcoSpold) {
        this.fileAttributes = fileAttributes;
        this.identifier = VocabularyEcoSpold.fileAttributesIRI + activityIdEcoSpold;
    }

    public String createFileAttributesInsertionQuery() {

        String query =
                "PREFIX " + VocabularyEcoSpold.ecoSpoldDataTypesPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldMetaInformationPrefix + "\n" +
                "PREFIX " + VocabularyEcoSpold.ecoSpoldFlowdataPrefix + "\n" +
                        "" + "\n" +
                        "insert {" + "\n" +
                        "?fileAttributes a " + VocabularyEcoSpold.fileAttributes + ";\n" +
                        VocabularyEcoSpold.majorRelease + " " + fileAttributes.getMajorRelease() + ";\n" +
                        VocabularyEcoSpold.minorRelease + " " + fileAttributes.getMinorRelease() + ";\n" +
                        VocabularyEcoSpold.majorRevision + " " + fileAttributes.getMajorRevision() + ";\n" +
                        VocabularyEcoSpold.minorRevision + " " + fileAttributes.getMinorRevision() + ";\n" +
                        VocabularyEcoSpold.internalSchemaVersion + " \"" + fileAttributes.getInternalSchemaVersion() + "\";\n" +
                        VocabularyEcoSpold.defaultLanguage + " \"" + fileAttributes.getDefaultLanguage() + "\";\n" +
                        VocabularyEcoSpold.creationTimestamp + " \"" + fileAttributes.getCreationTimestamp() + "\";\n" +
                        VocabularyEcoSpold.lastEditTimestamp + " \"" + fileAttributes.getLastEditTimestamp() + "\";\n" +
                        VocabularyEcoSpold.fileGenerator + " \"" + fileAttributes.getFileGenerator() + "\";\n" +
                        VocabularyEcoSpold.fileTimestamp + " \"" + fileAttributes.getFileTimestamp() + "\";\n" +
                        VocabularyEcoSpold.contextId + " \"" + fileAttributes.getContextId() + "\";\n" +
                        "} where {" + "\n" +
                        "BIND(IRI('" + identifier + "') AS ?fileAttributes)" + "\n" +
                        "}";

        return query;

    }

    public String getIdentifier() {
        return identifier;
    }
    
}
