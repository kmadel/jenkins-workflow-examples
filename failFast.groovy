stage 'parallel with failFast'
def error;
node {
  try {
    parallel(
      b: { error 'died' },
      // make sure this branch takes longer than b
      a: { sleep 35; writeFile text: '', file: 'a.done' },
      failFast: true
    )
  } catch (e) {
    error = e.toString()
  }
}
stage 'failFast Success with error'
echo "error: ${error}"
