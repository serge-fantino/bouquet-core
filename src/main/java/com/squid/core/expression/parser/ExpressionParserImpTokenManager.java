/* Generated By:JavaCC: Do not edit this line. ExpressionParserImpTokenManager.java */
package com.squid.core.expression.parser;
import java.io.StringReader;
import java.util.*;
import com.squid.core.expression.*;
import com.squid.core.expression.scope.*;

/** Token Manager. */
public class ExpressionParserImpTokenManager implements ExpressionParserImpConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 9:
         jjmatchedKind = 3;
         return jjMoveNfa_0(5, 0);
      case 10:
         jjmatchedKind = 4;
         return jjMoveNfa_0(5, 0);
      case 13:
         jjmatchedKind = 2;
         return jjMoveNfa_0(5, 0);
      case 32:
         jjmatchedKind = 1;
         return jjMoveNfa_0(5, 0);
      case 33:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 35:
         jjmatchedKind = 25;
         return jjMoveNfa_0(5, 0);
      case 36:
         jjmatchedKind = 27;
         return jjMoveNfa_0(5, 0);
      case 37:
         jjmatchedKind = 26;
         return jjMoveNfa_0(5, 0);
      case 38:
         jjmatchedKind = 24;
         return jjMoveNfa_0(5, 0);
      case 40:
         jjmatchedKind = 41;
         return jjMoveNfa_0(5, 0);
      case 41:
         jjmatchedKind = 42;
         return jjMoveNfa_0(5, 0);
      case 42:
         jjmatchedKind = 13;
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 43:
         jjmatchedKind = 10;
         return jjMoveNfa_0(5, 0);
      case 44:
         jjmatchedKind = 48;
         return jjMoveNfa_0(5, 0);
      case 45:
         jjmatchedKind = 11;
         return jjMoveNfa_0(5, 0);
      case 46:
         jjmatchedKind = 49;
         return jjMoveNfa_0(5, 0);
      case 47:
         jjmatchedKind = 14;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 58:
         jjmatchedKind = 51;
         return jjMoveNfa_0(5, 0);
      case 59:
         jjmatchedKind = 47;
         return jjMoveNfa_0(5, 0);
      case 60:
         jjmatchedKind = 15;
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 61:
         jjmatchedKind = 21;
         return jjMoveNfa_0(5, 0);
      case 62:
         jjmatchedKind = 17;
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 64:
         jjmatchedKind = 23;
         return jjMoveNfa_0(5, 0);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 70:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 91:
         jjmatchedKind = 45;
         return jjMoveNfa_0(5, 0);
      case 93:
         jjmatchedKind = 46;
         return jjMoveNfa_0(5, 0);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 123:
         jjmatchedKind = 43;
         return jjMoveNfa_0(5, 0);
      case 125:
         jjmatchedKind = 44;
         return jjMoveNfa_0(5, 0);
      default :
         return jjMoveNfa_0(5, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(5, 0);
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x20L) != 0L)
         {
            jjmatchedKind = 5;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 1;
         }
         break;
      case 61:
         if ((active0 & 0x10000L) != 0L)
         {
            jjmatchedKind = 16;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x40000L) != 0L)
         {
            jjmatchedKind = 18;
            jjmatchedPos = 1;
         }
         else if ((active0 & 0x400000L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 1;
         }
         break;
      case 65:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000200000000L);
      case 82:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 85:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjMoveNfa_0(5, 1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(5, 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(5, 1);
   }
   switch(curChar)
   {
      case 76:
         return jjMoveStringLiteralDfa3_0(active0, 0x280000000L);
      case 84:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000000L);
      case 85:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x280000000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
      default :
         break;
   }
   return jjMoveNfa_0(5, 2);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(5, 2);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(5, 2);
   }
   switch(curChar)
   {
      case 69:
         if ((active0 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000000L);
      case 76:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 3;
         }
         break;
      case 83:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000000L);
      case 101:
         if ((active0 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 32;
            jjmatchedPos = 3;
         }
         break;
      case 108:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 3;
         }
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000000L);
      default :
         break;
   }
   return jjMoveNfa_0(5, 3);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjMoveNfa_0(5, 3);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
   return jjMoveNfa_0(5, 3);
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x4000000000000L) != 0L)
         {
            jjmatchedKind = 50;
            jjmatchedPos = 4;
         }
         break;
      case 69:
         if ((active0 & 0x200000000L) != 0L)
         {
            jjmatchedKind = 33;
            jjmatchedPos = 4;
         }
         break;
      case 101:
         if ((active0 & 0x200000000L) != 0L)
         {
            jjmatchedKind = 33;
            jjmatchedPos = 4;
         }
         break;
      default :
         break;
   }
   return jjMoveNfa_0(5, 4);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int strKind = jjmatchedKind;
   int strPos = jjmatchedPos;
   int seenUpto;
   input_stream.backup(seenUpto = curPos + 1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { throw new Error("Internal Error"); }
   curPos = 0;
   int startsAt = 0;
   jjnewStateCnt = 75;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 5:
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAdd(54);
                  }
                  else if (curChar == 39)
                     jjCheckNAddStates(0, 2);
                  else if (curChar == 34)
                     jjCheckNAddStates(3, 5);
                  else if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 18;
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 0;
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 36)
                        kind = 36;
                     jjCheckNAddTwoStates(32, 33);
                  }
                  break;
               case 0:
                  if (curChar != 47)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddStates(6, 8);
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddStates(6, 8);
                  break;
               case 2:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 3:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 4:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 18:
                  if (curChar == 38 && kind > 20)
                     kind = 20;
                  break;
               case 19:
                  if (curChar == 38)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjCheckNAddTwoStates(32, 33);
                  break;
               case 33:
                  if (curChar != 32)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjCheckNAdd(33);
                  break;
               case 34:
                  if (curChar == 34)
                     jjCheckNAddStates(3, 5);
                  break;
               case 35:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 37:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 38:
                  if (curChar == 34 && kind > 37)
                     kind = 37;
                  break;
               case 39:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(9, 12);
                  break;
               case 40:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 41:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 42:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(40);
                  break;
               case 43:
                  if (curChar == 39)
                     jjCheckNAddStates(0, 2);
                  break;
               case 44:
                  if ((0xffffff7bffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 46:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 47:
                  if (curChar == 39 && kind > 38)
                     kind = 38;
                  break;
               case 48:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(13, 16);
                  break;
               case 49:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 50:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 51;
                  break;
               case 51:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(49);
                  break;
               case 53:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 39)
                     kind = 39;
                  jjstateSet[jjnewStateCnt++] = 53;
                  break;
               case 54:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(54);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 5:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 39)
                        kind = 39;
                     jjCheckNAddTwoStates(52, 53);
                  }
                  else if (curChar == 95)
                  {
                     if (kind > 40)
                        kind = 40;
                     jjCheckNAdd(54);
                  }
                  else if (curChar == 124)
                     jjstateSet[jjnewStateCnt++] = 10;
                  if (curChar == 70)
                     jjAddStates(17, 18);
                  else if (curChar == 102)
                     jjAddStates(19, 20);
                  else if (curChar == 77)
                     jjstateSet[jjnewStateCnt++] = 30;
                  else if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 24;
                  else if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 16;
                  else if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 13;
                  else if (curChar == 79)
                     jjstateSet[jjnewStateCnt++] = 8;
                  else if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 1:
                  if (kind > 6)
                     kind = 6;
                  jjAddStates(6, 8);
                  break;
               case 6:
                  if (curChar == 114 && kind > 19)
                     kind = 19;
                  break;
               case 7:
                  if (curChar == 111)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  if (curChar == 82 && kind > 19)
                     kind = 19;
                  break;
               case 9:
                  if (curChar == 79)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 124 && kind > 19)
                     kind = 19;
                  break;
               case 11:
                  if (curChar == 124)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 100 && kind > 20)
                     kind = 20;
                  break;
               case 13:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 14:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 15:
                  if (curChar == 68 && kind > 20)
                     kind = 20;
                  break;
               case 16:
                  if (curChar == 78)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 20:
                  if (curChar == 99 && kind > 30)
                     kind = 30;
                  break;
               case 21:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 22:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 22;
                  break;
               case 24:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 23;
                  break;
               case 25:
                  if (curChar == 109)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 26:
                  if (curChar == 67 && kind > 30)
                     kind = 30;
                  break;
               case 27:
                  if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 82)
                     jjstateSet[jjnewStateCnt++] = 27;
                  break;
               case 29:
                  if (curChar == 84)
                     jjstateSet[jjnewStateCnt++] = 28;
                  break;
               case 30:
                  if (curChar == 69)
                     jjstateSet[jjnewStateCnt++] = 29;
                  break;
               case 31:
                  if (curChar == 77)
                     jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 35:
                  if ((0xffffffffeffffffeL & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 36:
                  if (curChar == 92)
                     jjAddStates(21, 23);
                  break;
               case 37:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 44:
                  if ((0xffffffffeffffffeL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 45:
                  if (curChar == 92)
                     jjAddStates(24, 26);
                  break;
               case 46:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 52:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 39)
                     kind = 39;
                  jjCheckNAddTwoStates(52, 53);
                  break;
               case 53:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 39)
                     kind = 39;
                  jjCheckNAdd(53);
                  break;
               case 54:
                  if (curChar != 95)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(54);
                  break;
               case 55:
                  if (curChar == 102)
                     jjAddStates(19, 20);
                  break;
               case 56:
                  if (curChar == 114 && kind > 28)
                     kind = 28;
                  break;
               case 57:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 56;
                  break;
               case 58:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 59:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 58;
                  break;
               case 60:
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 59;
                  break;
               case 61:
                  if (curChar == 116 && kind > 29)
                     kind = 29;
                  break;
               case 62:
                  if (curChar == 101)
                     jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 63:
                  if (curChar == 99)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 64:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 65:
                  if (curChar == 70)
                     jjAddStates(17, 18);
                  break;
               case 66:
                  if (curChar == 82 && kind > 28)
                     kind = 28;
                  break;
               case 67:
                  if (curChar == 69)
                     jjstateSet[jjnewStateCnt++] = 66;
                  break;
               case 68:
                  if (curChar == 84)
                     jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 69:
                  if (curChar == 76)
                     jjstateSet[jjnewStateCnt++] = 68;
                  break;
               case 70:
                  if (curChar == 73)
                     jjstateSet[jjnewStateCnt++] = 69;
                  break;
               case 71:
                  if (curChar == 84 && kind > 29)
                     kind = 29;
                  break;
               case 72:
                  if (curChar == 69)
                     jjstateSet[jjnewStateCnt++] = 71;
                  break;
               case 73:
                  if (curChar == 67)
                     jjstateSet[jjnewStateCnt++] = 72;
                  break;
               case 74:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 73;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjAddStates(6, 8);
                  break;
               case 35:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(3, 5);
                  break;
               case 44:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(0, 2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 75 - (jjnewStateCnt = startsAt)))
         break;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { break; }
   }
   if (jjmatchedPos > strPos)
      return curPos;

   int toRet = Math.max(curPos, seenUpto);

   if (curPos < toRet)
      for (i = toRet - Math.min(curPos, seenUpto); i-- > 0; )
         try { curChar = input_stream.readChar(); }
         catch(java.io.IOException e) { throw new Error("Internal Error : Please send a bug report."); }

   if (jjmatchedPos < strPos)
   {
      jjmatchedKind = strKind;
      jjmatchedPos = strPos;
   }
   else if (jjmatchedPos == strPos && jjmatchedKind > strKind)
      jjmatchedKind = strKind;

   return toRet;
}
private int jjMoveStringLiteralDfa0_1()
{
   return 1;
}
private int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x100L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_2(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   44, 45, 47, 35, 36, 38, 1, 2, 4, 35, 36, 40, 38, 44, 45, 49, 
   47, 70, 74, 60, 64, 37, 39, 41, 46, 48, 50, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, "\53", "\55", 
"\52\52", "\52", "\57", "\74", "\74\75", "\76", "\76\75", null, null, "\75", "\41\75", 
"\100", "\46", "\43", "\45", "\44", null, null, null, null, null, null, null, null, 
null, null, null, null, null, "\50", "\51", "\173", "\175", "\133", "\135", "\73", 
"\54", "\56", "\104\101\124\105\50", "\72", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_LINE_COMMENT",
   "IN_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, 2, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, 
};
static final long[] jjtoToken = {
   0xffff3fffffc01L, 
};
static final long[] jjtoSkip = {
   0x17eL, 
};
static final long[] jjtoMore = {
   0x280L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[75];
private final int[] jjstateSet = new int[150];
protected char curChar;
/** Constructor. */
public ExpressionParserImpTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ExpressionParserImpTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 75; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 7)
         {
            jjmatchedKind = 7;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 9)
         {
            jjmatchedKind = 9;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
