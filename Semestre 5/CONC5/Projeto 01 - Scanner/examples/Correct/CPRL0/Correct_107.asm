   PROGRAM 13
   LDCSTR "Enter x:  "
   PUTSTR
   LDGADDR 0
   GETINT
   STOREW
   LDGADDR 8
   LDGADDR 0
   LOADW
   LDCINT 2
   MOD
   STOREW
   LDGADDR 12
   LDGADDR 0
   LOADW
   LDCINT 7
   CMP
   BLE L0
   LDCB 1
   BR L1
L0:
   LDCB 0
L1:
   STOREB
   LDGADDR 0
   LOADW
   LDCINT 0
   CMP
   BGE L8
   LDGADDR 4
   LDCINT 1
   NEG
   STOREW
L4:
   LDGADDR 0
   LDGADDR 0
   LOADW
   LDCINT 7
   LDCINT 3
   DIV
   ADD
   STOREW
   LDGADDR 0
   LOADW
   LDCINT 0
   CMP
   BG L5
   BR L4
L5:
   BR L9
L8:
   LDGADDR 0
   LOADW
   LDCINT 0
   CMP
   BNZ L12
   LDGADDR 4
   LDCINT 0
   STOREW
   BR L9
L12:
   LDGADDR 4
   LDCINT 1
   STOREW
L9:
   LDGADDR 12
   LOADB
   BNZ L13
   LDCB 0
   BR L14
L13:
   LDCB 0
   NOT
L14:
   BZ L15
   LDCSTR "TRUE   "
   PUTSTR
   BR L16
L15:
   LDCSTR "FALSE   "
   PUTSTR
L16:
   LDGADDR 0
   LOADW
   PUTINT
   LDCSTR "   "
   PUTSTR
   LDGADDR 4
   LOADW
   PUTINT
   LDCSTR "   "
   PUTSTR
   LDGADDR 8
   LOADW
   PUTINT
   PUTEOL
   HALT
