package com.spizzyrichlife.ussrpg_v01;

/**
 * Created by SpizzyRich on 9/6/16.
 */

//This class defines the Attribute object.
public class CharacterAttributes {
    int _id;
    int character_id; // Which character the attribute belongs to (TODO: decide if this should be the DECK_ID instead...)
    String stack; // Noun, Verb or Adjective; will define which type of cards the attribute will be the suite for
    String name; // The specific Noun, Verb or Adjective
    int rank; // 1-5; the power of the attribute; 1 min, 5 max
    String type; // Noun: Class, Prestige Class or Race; Verb: Attack or Maneuver; Adjective: Skill
    String synonyms; // A list of 4+ synonyms creating context for the uses of the attribute
    int stored_blues; // The number of blue bonus dice stored in this attributes suite

    public CharacterAttributes(int _id, int character_id, String stack, String name, int rank, String type, String synonyms, int stored_blues) {
        this._id = _id;
        this.character_id = character_id;
        this.stack = stack;
        this.name = name;
        this.rank = rank;
        this.type = type;
        this.synonyms = synonyms;
        this.stored_blues = stored_blues;
    }

    public int get_id() {
        return _id;
    }

    public int getCharacter_id() {
        return character_id;
    }

    public String getStack() {
        return stack;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getType() {
        return type;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public int getStored_blues() {
        return stored_blues;
    }
}
