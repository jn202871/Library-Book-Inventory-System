# Library Inventory

Simple program using a BST to store and retrieve nodes that represent books in a library.

The information of each book can be modified and the books can be checked in and out.

Book information and current CRN value will be stored in two generated text files stored in the local directory.

CRN values start at 0 and automatically increases and saves to a text file.

Note that deleted books CRN values are not reused, EX. if book a with CRN 2 is deleted and there is book b with CRN 3, a new book c will have a CRN of 4 instead of 2.
