node {
  try {
    parallel(
      b: { error 'died' },
      // make sure this branch takes longer than b
      a: { sleep 25; writeFile text: '', file: 'a.done' },
      failFast: true
    )
  } catch (ParallelStepException e) {
    echo e.toString()
  }
}
