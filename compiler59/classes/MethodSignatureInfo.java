package classes;// Replace your MethodSignatureInfo class in EnhancedSemanticErrorManager with this updated version

class MethodSignatureInfo {
    String methodName;
    String signature;
    String returnType;
    int line;  // Add line field

    MethodSignatureInfo(String methodName, String signature, String returnType) {
        this.methodName = methodName;
        this.signature = signature;
        this.returnType = returnType;
        this.line = 0;  // Default line
    }

    // Updated constructor with line parameter
    MethodSignatureInfo(String methodName, String signature, String returnType, int line) {
        this.methodName = methodName;
        this.signature = signature;
        this.returnType = returnType;
        this.line = line;
    }

    // Add getter method for line
    public int getLine() {
        return line;
    }
}