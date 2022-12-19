Form Data
==========================

Description
-----------
This module is intended to allow form engines to cache form data without needing to submit a form to the backend.

There are at least two use-cases for this:
1. To support "draft" forms where the form is retained but not translated into Obs, Orders, etc. until it has been confirmed,
signed, or some other similar activity.
2. To support storing the form-as-entered so that it can later be retrieved, potentially modified or printed without needing
to be reconstructed from the resulting encounter.

Forms in this module can be stored in two corresponding modes: "DRAFT" and "RESPONSE". For forms in "DRAFT" mode, there can
only be a single entry per form type and patient. For forms in "RESPONSE" mode, this business rule is not enforced.

Form data is stored by form and patient, optionally with an associated user.
