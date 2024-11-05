package com.ParseJSON.parseJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.DecimalNode;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class ParseJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Object parseJson(String jsonString) throws JsonProcessingException {
        JsonNode rootNode = objectMapper.readTree(jsonString);
        return convertJsonNode(rootNode);
    }

    private static Object convertJsonNode(JsonNode node) {
        if (node.isObject()) {
            return objectMapper.convertValue(node, Map.class);
        } else if (node.isArray()) {
            return objectMapper.convertValue(node, List.class);
        } else if (node.isBigInteger()) {
            return ((BigIntegerNode) node).bigIntegerValue();
        } else if (node.isBigDecimal()) {
            return ((DecimalNode) node).decimalValue();
        } else if (node.isNumber()) {
            if (node.isIntegralNumber()) {
                return node.bigIntegerValue();
            } else {
                return node.decimalValue();
            }
        } else if (node.isTextual()) {
            return node.asText();
        } else if (node.isBoolean()) {
            return node.asBoolean();
        } else if (node.isNull()) {
            return null;
        }
        throw new IllegalArgumentException("Unsupported JSON node type: " + node.getNodeType());
    }
}

